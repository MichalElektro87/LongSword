package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;

public class Player extends Person {

    private Rectangle leftAttackRectangle;
    private Rectangle rightAttackRectangle;
    private boolean canAttack = true;

    public Player(String name, ObjectType objectType, Array<Animation<TextureRegion>> animation, int health, int damage) {
        super(name, objectType,animation,health, damage);
        setXVelocity(4f);
        setYVelocity(4f);
        leftAttackRectangle = new Rectangle(getX(),getY() + 30f, 60f, 7f);
        rightAttackRectangle = new Rectangle(getX() + 75f, getY() + 30f, 60f, 7f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (getX() + getWidth() / 2 < 0)
            moveBy(4f,0f);

        if (getX() > 800 - getWidth() / 2)
            moveBy(-4f, 0f);


        calculateSwordCollisionRectanglePosition();

            if (!Gdx.input.isKeyPressed(Input.Keys.A) || !Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (!isAttackBlock()) {
                    if (isDirectionLeft())
                        setCurrentAnimation(0);
                    else
                        setCurrentAnimation(1);
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                setDirectionLeft(true);
                if (!isAttackBlock())
                    setCurrentAnimation(2);
                moveBy(-(getXVelocity()), 0f);

            }

            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                setDirectionLeft(false);
                if (!isAttackBlock())
                    setCurrentAnimation(3);
                moveBy(getXVelocity(), 0f);
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
                if (!hasActions()) {
                    addAction(Actions.sequence(Actions.moveBy(0f, 100f, 0.5f, Interpolation.fastSlow),
                            Actions.moveBy(0f, -100f, 0.5f, Interpolation.slowFast)));
                }
            }

        if (Gdx.input.isKeyJustPressed(Input.Keys.K) && !isAttackBlock()) {
            setAttackBlock(true);
            setElapsedTime(0f);
            if (isDirectionLeft())
                setCurrentAnimation(4);
            else
                setCurrentAnimation(5);
        }

        if (getElapsedTime() > getAnimation().get(4).getAnimationDuration()) {
            setAttackBlock(false);
            setCanAttack(true);
        }
    }

    public void calculateSwordCollisionRectanglePosition () {
        leftAttackRectangle.setPosition(getX(),getY() + 30f);
        rightAttackRectangle.setPosition(getX() + 75f, getY() + 30f);
    }

    public Rectangle getLeftAttackRectangle() {
        return leftAttackRectangle;
    }

    public void setLeftAttackRectangle(Rectangle leftAttackRectangle) {
        this.leftAttackRectangle = leftAttackRectangle;
    }

    public Rectangle getRightAttackRectangle() {
        return rightAttackRectangle;
    }

    public void setRightAttackRectangle(Rectangle rightAttackRectangle) {
        this.rightAttackRectangle = rightAttackRectangle;
    }

    public boolean isCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

}
